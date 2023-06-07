package com.example.okeyplay.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.R;
import com.example.okeyplay.adapter.CategoryAdapter;
import com.example.okeyplay.adapter.HitGameAdapter;
import com.example.okeyplay.adapter.NewGameAdapter;
import com.example.okeyplay.adapter.SaleGameAdapter;
import com.example.okeyplay.model.Category;
import com.example.okeyplay.model.HitGame;
import com.example.okeyplay.model.NewGame;
import com.example.okeyplay.model.SaleGame;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private MainViewModel viewModel;

    RecyclerView newgameRecycler, hitgameRecycler, salegameRecycler;

    NewGameAdapter newGameAdapter;
    HitGameAdapter hitGameAdapter;
    SaleGameAdapter saleGameAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<NewGame> newgameList = new ArrayList<>();
        newgameList.add(new NewGame(1, "new1", "Hogwarts\nLegacy", "Action", "Steam", "\t\t\tОднопользовательский ролевой экшн с открытым миром и несколькими вариантами сложности и доступности. В школе чародейства и волшебства Хогвартса можно будет посещать занятия, такие как заклинания, защита от темных искусств, травология и зельеварение.", "1999₽"));
        newgameList.add(new NewGame(2, "new2", "Atomic\nHeart", "Shooter", "VK Play", "\t\t\tКомпьютерная игра в жанре шутера от первого лица с элементами ролевой игры, разработанная российской студией Mundfish. Действие Atomic Heart происходит в альтернативном СССР, в котором страна вышла на массовое производство роботов, обслуживающих население страны.", "2299₽"));
        newgameList.add(new NewGame(3, "new3", "Dying Light 2:\nStay Human",  "Horror", "Steam", "\t\t\tКомпьютерная игра в жанре Action/RPG с видом от первого лица. Действие Dying Light 2 Stay Human происходит через 15 лет после вспышки зомби-вируса в Харране. Учёные мира, объединив усилия, нашли лекарство от харранского вируса.", "1899₽"));
        newgameList.add(new NewGame(4, "new4", "Saints Row",  "RPG", "Epic Games Store", "\t\t\tКомпьютерная игра в жанре action-adventure, разработанная студией Volition и изданная компанией Deep Silver. Действие Saints Row происходит в вымышленном городе Санто-Илесо, расположенном на юго-западе США.", "1499₽"));

        setNewGameRecycler(newgameList);

        List<HitGame> hitgameList = new ArrayList<>();
        hitgameList.add(new HitGame(1, "hit1", "Horizon Zero\nDawn", "Action", "Epic Games Store", "\t\t\tКомпьютерная игра в жанре action/RPG с открытым миром. Игрок управляет молодой охотницей Элой, которая отправляется в путешествие по постапокалиптическому миру, населённом механическими зверями-«машинами».", "2199₽"));
        hitgameList.add(new HitGame(2, "hit2", "Elden Ring", "Arcade", "Steam", "\t\t\tКомпьютерная игра в жанре action/RPG с открытым миром. Игроку доступно огромное количество разного оружия, доспехов, предметов и заклинаний — большее, чем в серии Souls. В игре есть около сотни навыков, которые игровой персонаж может изучить и использовать; в отличие от серии Souls.", "1899₽"));
        hitgameList.add(new HitGame(3, "hit3", "Far Cry 6", "Racing", "Ubisoft Connect", "\t\t\tКомпьютерная игра в жанре шутера от первого лица и action-adventure. Действие происходит в вымышленной тропической стране Яра, и повествует о противостоянии главного героя (или героини) местного сопротивления по имени Дани Рохас и жестокого диктатора Антона Кастильо.", "1299₽"));
        hitgameList.add(new HitGame(4, "hit4", "The Witcher\n3: Wild Hunt", "RPG", "Epic Games Store", "\t\t\tКомпьютерная игра в жанре action/RPG. мир которой основан на славянской мифологии, повествует о ведьмаке Геральте из Ривии, охотнике на чудовищ, чья приёмная дочь Цири находится в опасности, будучи преследуемой Дикой Охотой — загадочной потусторонней силой, тайна которой раскрывается по ходу игры.", "1499₽"));

        setHitGameRecycler(hitgameList);

        List<SaleGame> salegameList = new ArrayList<>();
        salegameList.add(new SaleGame(1, "sale1", "Doom Eternal", "Shooter", "Steam", "\t\t\tКомпьютерная игра в жанре шутера от первого лица. В рамках сюжетной кампании игрок вновь берет на себя роль Палача Рока, а события игры разворачиваются спустя два года после событий, произошедших на Марсе. Палач должен остановить Культ Деаг, который вместе с перешедшей на сторону Ада Объединённой Аэрокосмической Корпорацией собираются уничтожить человечество.", "1399₽"));
        salegameList.add(new SaleGame(2, "sale2", "God of War:\nRagnarök", "Action", "Steam", "\t\t\tКомпьютерная игра в жанре action-adventure с элементами hack and slash. Сюжет игры, как и сюжет предыдущей игры серии, построен вокруг дальнейших приключений главных героев — Кратоса и его сына Атрея в мире скандинавской мифологии. Действие игры разворачивается на территории древней Норвегии.", "2299₽"));
        salegameList.add(new SaleGame(3, "sale3", "The Last\nof Us", "Casual", "Steam", "\t\t\tКомпьютерная игра в жанре action-adventure с элементами survival horror и стелс-экшена. Действие игры происходит в постапокалиптическом будущем на территории бывших Соединённых Штатов Америки спустя двадцать лет после глобальной пандемии, вызванной опасно мутировавшим грибом кордицепс. Сюжет посвящён путешествию главных героев — контрабандиста Джоэла и девочки-подростка Элли.", "1199₽"));
        salegameList.add(new SaleGame(4, "sale4", "For Honor", "Fighting", "Epic Games Store", "\t\t\tКомпьютерная игра в жанре action с видом от третьего лица. В For Honor игроки могут управлять различными формами исторических солдат и воителей, из различных фракций, а именно: викингов, рыцарей, самураев, У Линь и фракцией иноземцев. Действие игры происходит в средневековом сеттинге.", "1099₽"));

        setSaleGameRecycler(salegameList);
    }

    private void setSaleGameRecycler(List<SaleGame> salegameList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        salegameRecycler = getView().findViewById(R.id.salegameRecycler);
        salegameRecycler.setLayoutManager(layoutManager);

        saleGameAdapter = new SaleGameAdapter(getContext(), salegameList);
        salegameRecycler.setAdapter(saleGameAdapter);
    }

    private void setHitGameRecycler(List<HitGame> hitgameList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        hitgameRecycler = getView().findViewById(R.id.hitgameRecycler);
        hitgameRecycler.setLayoutManager(layoutManager);

        hitGameAdapter = new HitGameAdapter(getContext(), hitgameList);
        hitgameRecycler.setAdapter(hitGameAdapter);
    }

    private void setNewGameRecycler(List<NewGame> newgameList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        newgameRecycler = getView().findViewById(R.id.newgameRecycler);
        newgameRecycler.setLayoutManager(layoutManager);

        newGameAdapter = new NewGameAdapter(getContext(), newgameList);
        newgameRecycler.setAdapter(newGameAdapter);
    }
}
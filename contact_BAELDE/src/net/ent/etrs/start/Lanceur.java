package net.ent.etrs.start;

import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.PresenterFactory;

public class Lanceur {
    public static void main(String[] args) {

        Presenter presenter = PresenterFactory.fabriquerContactPresenter();

        presenter.initialiser();

        presenter.executer();

    }
}

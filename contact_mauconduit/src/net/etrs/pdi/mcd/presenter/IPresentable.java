package net.etrs.pdi.mcd.presenter;

import net.etrs.pdi.mcd.presenter.exceptions.PresenterException;

public interface IPresentable {

    void initialiser();

    void executer() throws PresenterException;
}

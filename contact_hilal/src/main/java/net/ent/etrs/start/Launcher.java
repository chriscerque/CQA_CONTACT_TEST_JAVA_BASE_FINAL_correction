package net.ent.etrs.start;

import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.view.exceptions.ViewException;

public class Launcher
{
    public static void main(String[] args) {
        Presenter p = new Presenter();
        p.init();
        try {
            p.start();
        } catch (ViewException | BusinessException e) {
            throw new RuntimeException(e);
        }
    }
}

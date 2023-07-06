package com.youtube.questions;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.youtube.ui.BuscarVideoUI.LBL_NOMBRE_VIDEO;
import static com.youtube.utils.VariableGlobal.nombreVideo;


public class ValidarNombreVideo implements Question {

    @Override
    public Object answeredBy(Actor actor) {

        WebElementFacade mensaje = LBL_NOMBRE_VIDEO.resolveFor( actor );
        String nombreMensajeBienvenida = mensaje.getText();

        System.out.println( nombreVideo );
        return nombreVideo.equals( nombreMensajeBienvenida );
    }



        public static ValidarNombreVideo on(){
        return new ValidarNombreVideo();
    }

}

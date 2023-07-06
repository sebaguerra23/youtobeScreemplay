package com.youtube.interactions;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import java.util.List;
import java.util.Random;

import static com.youtube.ui.BuscarVideoUI.BTN_NOMBRE_VIDEO;
import static com.youtube.utils.VariableGlobal.nombreVideo;

public class ClickRamdom implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaNombreVideos = BTN_NOMBRE_VIDEO.resolveAllFor( actor );

        Random random = new Random();
        int indexRandom = random.nextInt( listaNombreVideos.size() );

        nombreVideo = listaNombreVideos.get( indexRandom ).getText();

        listaNombreVideos.get( indexRandom ).click();

    }

    public static ClickRamdom on( ) {
        return Tasks.instrumented( ClickRamdom.class );
    }
}

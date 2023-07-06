package com.youtube.stepDefinitions;

import com.youtube.questions.ValidarNombreVideo;
import com.youtube.taks.BuscarVideoTaks;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class BuscarVideoStepDefinition {
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }
    @Dado("que el usuario encuentre la url de de youtube")
    public void queElUsuarioEncuentreLaUrlDeDeYoutube() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://www.youtube.com/")
        );
    }
    @Cuando("el usuario selecccione el video")
    public void elUsuarioSelecccioneElVideo() {
        theActorInTheSpotlight().attemptsTo(
                BuscarVideoTaks.on()


        );
    }
    @Entonces("se validara que el video fue encontrado exitosamente")
    public void seValidaraQueElVideoFueEncontradoExitosamente() {

        theActorInTheSpotlight().should(
                seeThat(
                       ValidarNombreVideo.on(), Matchers.equalTo(true)
                )
        );
    }
}

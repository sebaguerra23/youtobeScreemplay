package com.youtube.taks;

import com.youtube.interactions.ClickRamdom;
import com.youtube.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static com.youtube.ui.BuscarVideoUI.LBL_BUSCAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarVideoTaks implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the( LBL_BUSCAR, isClickable() ).forNoMoreThan( 30 ).seconds(),
                    Enter.theValue( excel.leerDatosExcel( "Data.xlsx","Videos",1,0) ).into( LBL_BUSCAR ).thenHit( Keys.ENTER ),
                    ClickRamdom.on()



            );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }

    }
    public static Performable on(){

        return Tasks.instrumented(BuscarVideoTaks.class);
    }
}

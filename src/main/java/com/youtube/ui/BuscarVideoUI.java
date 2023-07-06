package com.youtube.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarVideoUI {
    public static final Target LBL_BUSCAR= Target.the( "Lbl buscar" )
            .located( By.xpath("//div/input[@id='search']") );
    public static final Target BTN_NOMBRE_VIDEO = Target.the( "Txt nombre video" )
            .located( By.xpath("//div/h3[@class='title-and-badge style-scope ytd-video-renderer']") );
    public static final Target LBL_NOMBRE_VIDEO= Target.the( "Txt nombre video" )
            .located( By.xpath("(//h1)[2]") );


}

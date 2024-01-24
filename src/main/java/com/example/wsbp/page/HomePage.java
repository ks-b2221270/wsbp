package com.example.wsbp.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import com.example.wsbp.service.ISampleService;
import org.apache.wicket.spring.injection.annot.SpringBean;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {
    @SpringBean
    private ISampleService service;

    public HomePage() {
        var youModel = Model.of("b2221270");
        var youLabel = new Label("gakuseki", youModel);
        add(youLabel);
        var youModel2 = Model.of("澁谷一真");
        var youLabel2 = new Label("name", youModel2);
        add(youLabel2);

        var timeModel = Model.of(service.makeCurrentHMS());
        var timeLabel = new Label("time", timeModel);
        add(timeLabel);

        var randModel=Model.of(service.makeRandInt());
        var randLabel=new Label("rand",randModel);
        add(randLabel);
        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMakerPage.class);
        add(toUserMakerLink);
        var toUserDeleterLink = new BookmarkablePageLink<>("toUserDeleter", UserDeletePage.class);
        add(toUserDeleterLink);
    }

}


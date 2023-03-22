package com.revature;

import com.revature.dto.MesssageDTO;
import io.javalin.Javalin;

public class Main {

    private static int host = 3000;
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/", (ctx) -> {
            ctx.json(new MesssageDTO("Server online"));
        });


        app.start(host);
    }
}
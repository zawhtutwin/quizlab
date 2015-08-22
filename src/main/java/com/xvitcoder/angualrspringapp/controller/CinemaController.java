package com.xvitcoder.angualrspringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/cinemas")
public class CinemaController {

     @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "cinemas/layout";
    }
}

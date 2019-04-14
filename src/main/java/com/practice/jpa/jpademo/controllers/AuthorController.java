package com.practice.jpa.jpademo.controllers;

import com.practice.jpa.jpademo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by TechSavyThor on 7/04/2019
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
@RequestMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }
}

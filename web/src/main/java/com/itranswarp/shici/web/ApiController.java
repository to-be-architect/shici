package com.itranswarp.shici.web;

import com.itranswarp.shici.bean.Dynasty;
import com.itranswarp.shici.bean.Poem;
import com.itranswarp.shici.bean.Poet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Provide REST API.
 *
 * @author liaoxuefeng
 */
@RestController
public class ApiController extends AbstractController {

    static final String[] EMPTY_SUGGUESTS = new String[0];

    @GetMapping("/api/dynasties")
    public List<Dynasty> getDynasties() {
        return this.poemService.getDynasties();
    }

    @GetMapping("/api/dynasties/{id}")
    public Dynasty getDynasty(@PathVariable("id") long id) {
        return this.poemService.getDynasty(id);
    }

    @GetMapping("/api/dynasties/{id}/poets")
    public List<Poet> getPoets(@PathVariable("id") long id) {
        return this.poemService.getPoets(id);
    }

    @GetMapping("/api/poets/{id}")
    public Poet getPoet(@PathVariable("id") long id) {
        return this.poemService.getPoet(id);
    }

    @GetMapping("/api/poet/{id}/poems")
    public List<Poem> getPoems(@PathVariable("id") long id) {
        return this.poemService.getPoems(id);
    }

    @GetMapping("/api/poems/{id}")
    public Poem getPoem(@PathVariable("id") long id) {
        return this.poemService.getPoem(id);
    }

    @GetMapping("/api/poems/today")
    public Poem getTodayPoem() {
        return this.poemService.getFeatured();
    }

    @GetMapping("/api/suggest")
    public String[] suggest(@RequestParam(value = "q", defaultValue = "") String q) throws IOException {
        if (q.trim().isEmpty()) {
            return EMPTY_SUGGUESTS;
        }
        return this.searchService.suggest(q);
    }
}

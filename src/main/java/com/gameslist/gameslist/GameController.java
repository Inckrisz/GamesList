package com.gameslist.gameslist;

import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public ResponseEntity<List<Game>> allGames()
    {
        return new ResponseEntity<List<Game>>(gameService.allGames(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Game>>(gameService.singleGame(id), HttpStatus.OK);
    }

    @GetMapping("/developer/{developer}")
    public ResponseEntity<Optional<List<Game>>> getDeveloperGames(@PathVariable String developer) {
        return new ResponseEntity<Optional<List<Game>>>(gameService.developerGames(developer), HttpStatus.OK);
    }

    @PostMapping("/addGame")
    public ResponseEntity<Game> addGame(@RequestBody Game game)
    {
        Game gameObj = gameRepository.save(game);

        return new ResponseEntity<>(gameObj, HttpStatus.OK);
    }
}

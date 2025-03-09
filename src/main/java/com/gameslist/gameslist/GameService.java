package com.gameslist.gameslist;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

   public List<Game> allGames() {
       return gameRepository.findAll();
   }

   public Optional<Game> singleGame(ObjectId id)
   {
       return gameRepository.findById(id);
   }

   public Optional<List<Game>> developerGames(String developer)
   {
//       List<Game> games =  gameRepository.findAll().stream()
//               .filter(g -> g.getDeveloper().equals(developer))
//               .collect(Collectors.toList());
//
//       return Optional.ofNullable(games.isEmpty() ? null : games);

       return Optional.ofNullable(gameRepository.findByDeveloper(developer));
   }
}

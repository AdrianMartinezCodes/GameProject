# Introduction 
I started this project originally to implement skills I had learned in my CS courses. This enabled me to: practice with the material in a less(but still non zero) convoluted environment, and reinforce those fundamentals. I chose to make a game as I had played many video games in my adolescence and could make the connections from class to games very easily.

In this repository you'll find my efforts to ultimately build a simple game, with a GUI, using the least amount of libraries possible. I also try to implement a TDD approach and unit testing. 

I intended for this game to be rogue-like. However, I have recently decided to focus on the engine development and may change the game to a different genre.

## Game mechanics

As of April 1st, the game features a field, player characters, and mobs. The field can randomly generate what I have chosen to call entities. These entities are objects that will represent anything that is a "alive" and have a variety of characterics that are ever increasing. The player character(s) and mobs extend the entity class and each has their own characteristics. I have further made the entities able to interact with each other, but can only attack as of now.

## Current Work

Currently, I am working on the field class. I am in the process of (randomly) generating static terran to the field(examples are: bushes, rocks, trees). After this is done, I will learn and implement a save/load system. There is an ever increasing list of ideas once this is achieved that I have not finished collecting my ideas.

## Future Works
Ultimately, there isn't a complete vision for this project. I am constantly thinking of new things to try and implement as all of it increases my knowledge of programming. This game is merely a way for me to practice and gain experience with programming in an environment I am very familiar in. 

I do, however, envision using this program to help beginners code. Once the GUI is running, I think it would be a great idea to introduce someone to the ideas of OOD through an explicit example. One could extend the mob field for instance and make their own entity with supported characterics and see it pop up in the game after compiling. I think that approach makes it fun as you can see your hard work on the screen instead of a completely abstract idea.

## Closing remarks

If anyone is also interested in honing their skills or implementing their own design, you are welcome to fork this project. Ultimately, if this project has helped you in any way I am happy for that to be the case. I only ask for credit in return

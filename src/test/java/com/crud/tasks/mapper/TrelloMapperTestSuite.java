package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import net.bytebuddy.matcher.FilterableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;



    @Test
    void testMapToBoards() {
        //Given
        List<TrelloBoardDto> testBoardDtoList = new ArrayList<>();
        testBoardDtoList.add(new TrelloBoardDto("test trello board dto", "test id", new ArrayList<>()));
        //When
        List<TrelloBoard> mappedTrelloBoard = trelloMapper.mapToBoards(testBoardDtoList);
        //Then
        assertEquals(mappedTrelloBoard.get(0).getId(), testBoardDtoList.get(0).getId());
        }

    @Test
    void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> testTrelloBoardsList = new ArrayList<>();
        testTrelloBoardsList.add(new TrelloBoard("test id", "test trello board", new ArrayList<>()));
        //When
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapToBoardsDto(testTrelloBoardsList);
        //Then
        assertEquals(mappedTrelloBoardDto.get(0).getId(), testTrelloBoardsList.get(0).getId());
    }

    @Test
    void testMapToList() {
        List<TrelloListDto> testTrelloListDto = new ArrayList<>();
        testTrelloListDto.add(new TrelloListDto("test id", "test trello list dto", true));
        //When
        List<TrelloList> mappedTrelloList = trelloMapper.mapToList(testTrelloListDto);
        //Then
        assertEquals(mappedTrelloList.get(0).getId(), testTrelloListDto.get(0).getId());
    }

    @Test
    void testMapToListDto() {
        List<TrelloList> testTrelloList = new ArrayList<>();
        testTrelloList.add(new TrelloList("test id", "test trello list", true));
        //When
        List<TrelloListDto> mappedTrelloListDto = trelloMapper.mapToListDto(testTrelloList);
        //Then
        assertEquals(mappedTrelloListDto.get(0).getId(), testTrelloList.get(0).getId());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard testTrelloCard = new TrelloCard("test card", "test card description", "top","test list id");
        //When
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(testTrelloCard);
        //Then
        assertEquals(mappedTrelloCardDto.getName(), testTrelloCard.getName());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto testTrelloCardDto = new TrelloCardDto("test card","test card description","top","test list id");
        //When
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(testTrelloCardDto);
        //Then
        assertEquals(mappedTrelloCard.getName(), testTrelloCardDto.getName());
    }

}

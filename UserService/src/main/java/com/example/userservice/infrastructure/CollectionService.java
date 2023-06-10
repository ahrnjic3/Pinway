package com.example.userservice.infrastructure;

import com.example.userservice.dto.CollectionDTO;
import com.example.userservice.dto.CollectionUpdateDTO;
import com.example.userservice.dto.CollectionUserDTO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CollectionService {

    @Autowired
    private RestTemplate restTemplate;

    public Boolean DoesExist(Integer collectionId)  {
        ResponseEntity<CollectionDTO> responseEntity = restTemplate.getForEntity("http://collection-service/api/collections/{id}", CollectionDTO.class, collectionId);
        CollectionDTO collectionDTO = responseEntity.getBody();

        if(collectionDTO.getId() != collectionId)
            return false;

        return true;
    }

    public Boolean UpdateCollectionVisibility(Integer collectionId, String visibility) {
        String resourceUrl = "http://collection-service/api/collections/" + collectionId;
        HttpEntity<CollectionUpdateDTO> request = new HttpEntity<CollectionUpdateDTO>(new CollectionUpdateDTO(visibility));

        restTemplate.exchange(resourceUrl,
                                HttpMethod.PUT,
                                request,
                                Void.class);
        return true;
    }

//    public List<CollectionDTO> GetAllCollectionsForUser(Set<Integer> ids) {
//        List<CollectionDTO> collectionDTOS = new ArrayList<>();
//
//        if(ids.isEmpty())
//            return collectionDTOS;
//
//        String listOfIds = ids.stream().map(Object::toString).collect(Collectors.joining(","));
//        ResponseEntity<CollectionDTO[]> responseEntity = restTemplate.getForEntity("http://collection-service/api/collections?ids={ids}", CollectionDTO[].class, listOfIds);
//        CollectionDTO[]  collectionDTOS1 = responseEntity.getBody();
//
//
//        for(CollectionDTO collectionDTO : collectionDTOS1) {
//            collectionDTOS.add(collectionDTO);
//        }
//
//        return collectionDTOS;
//    }

    public List<CollectionDTO> GetAllCollectionsForUser(Integer id) {
        List<CollectionDTO> collectionDTOS = new ArrayList<>();

        ResponseEntity<CollectionDTO[]> responseEntity = restTemplate.getForEntity("http://collection-service/api/collections/user/{id}", CollectionDTO[].class, id);
        CollectionDTO[]  collectionDTOS1 = responseEntity.getBody();


        for(CollectionDTO collectionDTO : collectionDTOS1) {
            collectionDTOS.add(collectionDTO);
        }

        return collectionDTOS;
    }

}

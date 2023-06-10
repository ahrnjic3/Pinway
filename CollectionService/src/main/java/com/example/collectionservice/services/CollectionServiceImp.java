package com.example.collectionservice.services;

import com.example.collectionservice.dto.*;
import com.example.collectionservice.exception.PinwayError;
import com.example.collectionservice.models.Collection;
import com.example.collectionservice.models.CollectionVisibilityType;
import com.example.collectionservice.models.CollectionPost;
import com.example.collectionservice.repositories.CollectionRepository;
import com.example.collectionservice.repositories.CollectionVisibilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImp implements CollectionService{

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CollectionRepository collectionRepository;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CollectionVisibilityTypeRepository collectionVisibilityTypeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Collection Create(Collection collection) {
        collection.setCreatedAt(LocalDate.now());
        Collection newCollection = collectionRepository.save(collection);
        return newCollection;
    }


    // svi i obrisani i ne
    @Override
    public Iterable<Collection> List() {
        Iterable<Collection> collectionList = collectionRepository.findAll();
        return collectionList;
    }

    // samo koji nisu obrisani
    @Override
    public Iterable<Collection> FindAllByIds(Iterable<Integer> ids) {
        Iterable<Collection> collections = collectionRepository.findAllByIsDeletedAndIdIn(false, ids);
        return  collections;
    }

    @Override
    public Iterable<Collection> FindAllByUserId(Integer id) {
        Iterable<Collection> collections = collectionRepository.findAllByIsDeletedAndUserId(false, id);
        return  collections;
    }

    @Override
    public Collection Details(Integer id) {

        Optional<Collection> collection = collectionRepository.findByIdAndIsDeleted(id, false);

        if (!collection.isPresent())
            throw new PinwayError("Not found Collection with id = " + id);

        return collection.get();


    }

    @Override
    public Boolean Delete(Integer id) {

        Optional<Collection> optionalCollection = collectionRepository.findById(id);

        if (!optionalCollection.isPresent()) {
            throw new PinwayError("Not found Collection with id = " + id);
        }
        Collection collection = optionalCollection.get();

        collection.setDeleted(true);
        collectionRepository.save(collection);
        return true;

    }

    @Override
    public Collection Update(Integer id, Collection c) {

        Optional<Collection> collection = collectionRepository.findById(id);

        if (!collection.isPresent())
            throw new PinwayError("Not found Collection with id = " + id);

        Collection newCollection = collection.get();

        newCollection.setName(c.getName());
        newCollection.setNumOfPosts(c.getNumOfPosts());
        newCollection.setCreatedAt(c.getCreatedAt());
        newCollection.setCollectionVisibilityType(c.getCollectionVisibilityType());

        collectionRepository.save(newCollection);
        return newCollection;
    }

    @Override
    public Collection ChangeVisibilityType(Integer id, CollectionVisibilityTypeOnlyTypeDTO collectionVisibilityTypeOnlyTypeDTO) {
        Optional<Collection> optCollection = collectionRepository.findById(id);

        if (!optCollection.isPresent())
            throw new PinwayError("Not found Collection with id = " + id);

        Collection collection = optCollection.get();

        Optional<CollectionVisibilityType> optCollectionVisibilityType = collectionVisibilityTypeRepository.findOneByType(collectionVisibilityTypeOnlyTypeDTO.getType());

        if (!optCollectionVisibilityType.isPresent())
            throw new PinwayError("Not found Collection Visibility Type  = " + collectionVisibilityTypeOnlyTypeDTO.getType());

        CollectionVisibilityType collectionVisibilityType = optCollectionVisibilityType.get();

        collection.setCollectionVisibilityType(collectionVisibilityType);

        return collectionRepository.save(collection);

    }


    @Override
    public Iterable<CollectionVisibilityType> ListVisibilityTypes() {

        Iterable<CollectionVisibilityType> collectionVisibilityTypes = collectionVisibilityTypeRepository.findAll();
        return collectionVisibilityTypes;
    }
}

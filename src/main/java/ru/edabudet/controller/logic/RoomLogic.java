package ru.edabudet.controller.logic;

import ru.edabudet.model.Room;
import ru.edabudet.utils.EMF;

import javax.persistence.NoResultException;


public class RoomLogic extends EMF {

    public Long createRoom(String password){

        Room room = new Room();
        room.setPassword(password);

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            em.persist(room);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Не удалось добавить объект: " + e.getMessage());
        }finally {
            em.close();
        }

        return room.getId();
    }

    public Boolean connectRoom(Long id, String password){

        Boolean out;

        em = EMF.getEm();
        try {
            em.getTransaction().begin();
            Room room = em.find(Room.class, id);
            em.getTransaction().commit();
            if (password.equals(room.getPassword())) {
                out = true;
            } else {
                out = false;
            }
        }catch (NoResultException e){
            return false;
        }
        finally {
            em.close();
        }

        return out;
    }
}

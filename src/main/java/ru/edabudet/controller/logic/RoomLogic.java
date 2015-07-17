package ru.edabudet.controller.logic;

import ru.edabudet.model.Room;
import ru.edabudet.utils.EMF;


public class RoomLogic extends EMF {

    public Long createRoom(String password){

        Room room = new Room();
        room.setPassword(password);

        em = EMF.getEm();
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
        em.close();

        return room.getId();
    }

    public Boolean connectRoom(Long id, String password){

        Boolean out;

        em = EMF.getEm();
        em.getTransaction().begin();
        Room room = em.find(Room.class, id);
        em.getTransaction().commit();
        em.close();

        if (password.equals(room.getPassword())) {
            out = true;
        } else {
            out = false;
        }

        return out;
    }
}

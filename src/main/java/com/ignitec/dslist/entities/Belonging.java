package com.ignitec.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "tb_belonging")
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelonginkPK id = new BelonginkPK();

    private Integer position;

    public Belonging() {
    }

    public Belonging(Integer position, Game game, GameList gameList) {
        this.position = position;
        this.id.setGame(game);
        this.id.setGameList(gameList);
    }

    public BelonginkPK getId() {
        return id;
    }

    public void setId(BelonginkPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

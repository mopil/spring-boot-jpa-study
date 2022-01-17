package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DB에 저장될 때 싱글 테이블로 저장되기 때문에 각각 구분하기 위해서 필요한 값인듯
@Getter @Setter
public class Album extends Item{

    private String artist;
    private String etc;
}

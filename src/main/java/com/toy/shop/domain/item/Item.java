package com.toy.shop.domain.item;

import com.toy.shop.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import static com.toy.shop.code.DBLength.*;

@Entity
@Getter
@Table(name = "items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = ITEM_CD_LENGTH, nullable = false)
    @Comment("상품코드")
    private String itemCd;

    @Column(length = ITEM_NM_LENGTH, nullable = false)
    @Comment("상품명")
    private String itemNm;

    @Column(length = MANUFACTURER_LENGTH)
    @Comment("제조사")
    private String manufacturer;

    @Type(type = "yes_no")
    @Column(length = YN_LENGTH, nullable = false)
    @Comment("판매여부")
    private boolean onSale;

    @Type(type = "yes_no")
    @Column(length = YN_LENGTH, nullable = false)
    @Comment("노출 여부")
    private boolean onDisplay;

    @Type(type = "yes_no")
    @Column(length = 1, nullable = false)
    @Comment("삭제 여부")
    private boolean deleted;
}

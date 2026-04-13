package esport.lol.lolfm.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ObjectStat {

    // 전투력 스탯
    private int laning; // 라인전 능력
    private int teamFight; // 한타 능력

    // 가중치 스탯 (이 값들이 정규분포의 평균이 됨)
    private int metaAdapt; // 메타 적응력
    private int bigGameClutch; // 빅게임 능력

    // 변동성 제어 스탯 (표준편차 결정)
    private int consistency;
}

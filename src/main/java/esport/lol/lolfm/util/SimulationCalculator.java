package esport.lol.lolfm.util;

import java.util.Random;

public class SimulationCalculator {

    private static final Random random = new Random();

    /**
     * @param weight      기본 가중치 (평균값)
     * @param consistency 선수의 일관성 (0 ~ 100)
     * @return 정규분포가 반영된 최종 가중치
     */
    public double calculateDynamicWeight(int weight, int consistency) {
        // 1. 표준편차 결정: 일관성이 높을수록 편차는 작아짐
        // (예: 일관성 100일 때 편차 0.1, 일관성 0일 때 편차 5.0)
        double sigma = (100 - consistency) / 20.0;

        // 2. 정규분포 난수 생성 (평균 0, 표준편차 1)
        double gaussian = random.nextGaussian();

        // 3. 최종 결과값 = 평균 + (난수 * 표준편차)
        double result = weight + (gaussian * sigma);

        // 4. 최소/최대 보정 (필요시)
        return Math.max(0, result);
    }
}

package Xujunchao;

public class Bean {
    private String x;
    private Integer lll;
    private boolean boolar;
    //数组的情况
    private Test1 test1;
    private Test2[] test2;

    public class Test1 {
        private String x;
        private Integer lll;
        public Test2 test;
        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public Integer getLll() {
            return lll;
        }

        public void setLll(Integer lll) {
            this.lll = lll;
        }
    }

    public class Test2 {
        private String test21;
        private Integer test22;

        public String getTest21() {
            return test21;
        }

        public void setTest21(String test21) {
            this.test21 = test21;
        }

        public Integer getTest22() {
            return test22;
        }

        public void setTest22(Integer test22) {
            this.test22 = test22;
        }
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Integer getLll() {
        return lll;
    }

    public void setLll(Integer lll) {
        this.lll = lll;
    }

    public boolean isBoolar() {
        return boolar;
    }

    public void setBoolar(boolean boolar) {
        this.boolar = boolar;
    }

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public Test2[] getTest2() {
        return test2;
    }

    public void setTest2(Test2[] test2) {
        this.test2 = test2;
    }
}

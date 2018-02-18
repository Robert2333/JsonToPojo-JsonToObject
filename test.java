public class 徐俊超测试名字 {
    //我是注释1
    private Hello hello;

    public class Hello {
        //
        private String test1;
        //
        private Test2 test2;

        public class Test2 {
            //
            private Xjc[] xjc;

            public class Xjc {
                //
                private Integer 最后一层;

                public void set最后一层(Integer 最后一层) {
                    this.最后一层 = 最后一层;
                }

                public Integer get最后一层() {
                    return this.最后一层;
                }
            }

            public void setXjc(Xjc[] xjc) {
                this.xjc = xjc;
            }

            public Xjc[] getXjc() {
                return this.xjc;
            }
        }

        public void setTest1(String test1) {
            this.test1 = test1;
        }

        public String getTest1() {
            return this.test1;
        }

        public void setTest2(Test2 test2) {
            this.test2 = test2;
        }

        public Test2 getTest2() {
            return this.test2;
        }
    }

    //你妈嗨
    private Integer test;

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public Hello getHello() {
        return this.hello;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getTest() {
        return this.test;
    }
}

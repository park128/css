import Vue from "https://cdn.jsdelivr.net/npm/vue@2.6.11/dist/vue.esm.browser.js";
import bezierEasing from "https://cdn.skypack.dev/bezier-easing@2.1.0";

const ease = bezierEasing(0.25, 0.1, 0.25, 1.0);
const easeIn = bezierEasing(0.38, 0.01, 0.78, 0.13);
const midSlow = bezierEasing(0, 0.7, 1, 0.3);

const def = {
    height: 7100,
    elements: {
        sl1: {
            top: 500,
            bottom: 1900,
            topStyle: {
                opacity: 0,
                translateY: -60
            },
            bottomStyle: {
                opacity: 0,
                translateY: 60
            }
        },
        scdown: {
            top: 0,
            bottom: 1000,
            topStyle: {
                opacity: 1
            },
            bottomStyle: {
                opacity: 0
            }
        },
        sl2: {
            top: 1900,
            bottom: 3200,
            topStyle: {
                opacity: 0,
                translateY: -60
            },
            bottomStyle: {
                opacity: 0,
                translateY: 60
            }
        },
        sl3: {
            top: 3300,
            bottom: 4600,
            topStyle: {
                opacity: 0
            },
            bottomStyle: {
                opacity: 0
            }
        },
        wave: {
            top: 4500,
            bottom: 5900,
            topStyle: {
                opacity: 0,
                translateY: 300
            },
            bottomStyle: {
                opacity: 0,
                translateY: 0
            }
        },
        sl4: {
            top: 4700,
            bottom: 6000,
            topStyle: {
                opacity: 0
            },
            bottomStyle: {
                opacity: 0
            }
        },
        sl5: {
            top: 6100,
            bottom: 9000,
            topStyle: {
                opacity: 0
            },
            bottomStyle: {
                opacity: 0
            }
        }
    },
    animations: {
        sl1: [
            {
                top: 500,
                bottom: 1900,
                easing: midSlow,
                styles: {
                    translateY: {
                        topValue: 60,
                        bottomValue: -60
                    }
                }
            },
            {
                top: 500,
                bottom: 800,
                easing: ease,
                styles: {
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            },
            {
                top: 1400,
                bottom: 1900,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        scdown: [
            {
                top: 600,
                bottom: 1000,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        sl2: [
            {
                top: 1900,
                bottom: 3200,
                easing: midSlow,
                styles: {
                    translateY: {
                        topValue: 60,
                        bottomValue: -60
                    }
                }
            },
            {
                top: 1900,
                bottom: 2500,
                easing: ease,
                styles: {
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            },
            {
                top: 2600,
                bottom: 3200,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        sl3: [
            {
                top: 3300,
                bottom: 4600,
                easing: midSlow,
                styles: {
                    translateY: {
                        topValue: 60,
                        bottomValue: -60
                    }
                }
            },
            {
                top: 3300,
                bottom: 3900,
                easing: ease,
                styles: {
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            },
            {
                top: 4000,
                bottom: 4600,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        wave: [
            {
                top: 4500,
                bottom: 5300,
                easing: ease,
                styles: {
                    translateY: {
                        topValue: 200,
                        bottomValue: 0
                    },
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            },
            {
                top: 5300,
                bottom: 5900,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        sl4: [
            {
                top: 4700,
                bottom: 6000,
                easing: midSlow,
                styles: {
                    translateY: {
                        topValue: 60,
                        bottomValue: -60
                    }
                }
            },
            {
                top: 4700,
                bottom: 5300,
                easing: ease,
                styles: {
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            },
            {
                top: 5400,
                bottom: 6000,
                easing: easeIn,
                styles: {
                    opacity: {
                        topValue: 1,
                        bottomValue: 0
                    }
                }
            }
        ],
        sl5: [
            {
                top: 6100,
                bottom: 7100,
                easing: midSlow,
                styles: {
                    translateY: {
                        topValue: 60,
                        bottomValue: -60
                    }
                }
            },
            {
                top: 6100,
                bottom: 6700,
                easing: ease,
                styles: {
                    opacity: {
                        topValue: 0,
                        bottomValue: 1
                    }
                }
            }
        ]
    }
};

let enabled = new Map();
let disabled = new Map();

const isAmong = (num, top, bottom) => num >= top && num <= bottom;

const applyStyle = (element, styleName, value, unit = "px") => {
    if (styleName === "translateY") {
        // eslint-disable-next-line no-param-reassign
        element.style.transform = `translateY(${value}${unit})`;
        return;
    }
    if (styleName === "translateX") {
        // eslint-disable-next-line no-param-reassign
        element.style.transform = `translateX(${value}${unit})`;
        return;
    }
    // eslint-disable-next-line no-param-reassign
    element.style[styleName] = value;
};

const component = new Vue({
    el: "#app",
    data() {
        return {
            message: "Welcome to Vue!"
        };
    },
    mounted() {
        this.init();
        window.addEventListener("scroll", this.onScroll);
    },
    beforeDestroy() {
        window.removeEventListener("scroll", this.onScroll);
    },

    methods: {
        init() {
            this.initAnimation();
        },
        // 애니메이션 초기화
        initAnimation() {
            // Sticky Conainer 의 높이를 설정함.
            this.$refs["sticky-container"].style.height = `${def.height}px`;

            // disabled, enabled 를 비움.
            disabled.clear();
            enabled.clear();

            // 모든 요소를 disabled 에 넣음.
            for (const refname of Object.keys(def.elements)) {
                disabled.set(refname, def.elements[refname]);
            }

            // 각 애니메이션을 enabled == false 로 만듬.
            for (const refname of Object.keys(def.animations)) {
                for (const animation of def.animations[refname]) {
                    animation.enabled = false;
                }
            }

            // 초기 스타일 적용
            disabled.forEach((obj, refname) => {
                Object.keys(obj.topStyle).forEach((styleName) => {
                    const pushValue = obj.topStyle[styleName];
                    this.$refs[refname].style[styleName] = pushValue;
                });
            });

            // 이미 요소의 범위 및 애니메이션의 범위에 있는 것들을 렌더링하기 위해
            // 임의로 스크롤 이벤트 핸들러를 한 번 실행시킴.
            this.onScroll();
        },
        applyStyles(currentPos, refname, styles, r, unit = "px") {
            for (const style of Object.keys(styles)) {
                const { topValue, bottomValue } = styles[style];
                const calc = (bottomValue - topValue) * r + topValue;
                applyStyle(this.$refs[refname], style, calc, unit);
            }
        },
        applyAllAnimation(currentPos, refname) {
            const animations = def.animations[refname];
            if (!animations) return;
            for (const animation of animations) {
                const { top: a_top, bottom: a_bottom, easing, styles } = animation;
                const isIn = isAmong(currentPos, a_top, a_bottom);
                // 만약 애니메이션이 새롭게 들어갈 때 혹은 나갈때 enabled 설정
                if (isIn) {
                    if (!animation.enabled) animation.enabled = true;
                } else if (!isIn && animation.enabled) {
                    if (currentPos <= a_top) {
                        this.applyStyles(currentPos, refname, styles, 0);
                    } else if (currentPos >= a_bottom) {
                        this.applyStyles(currentPos, refname, styles, 1);
                    }
                    // eslint-disable-next-line no-param-reassign
                    animation.enabled = false;
                }

                // 애니메이션이 enabled 라면, 애니메이션 적용.
                if (animation.enabled) {
                    const r = easing((currentPos - a_top) / (a_bottom - a_top));
                    // eslint-disable-next-line no-param-reassign
                    this.applyStyles(currentPos, refname, styles, r);
                }
            }
        },
        onScroll() {
            // 현재 스크롤 위치 파악
            const scrollTop = window.scrollY || window.pageYOffset;
            const currentPos = scrollTop + window.innerHeight / 2;

            // disabled 순회하며 활성화할 요소 찾기.
            disabled.forEach((obj, refname) => {
                // 만약 칸에 있다면 해당 요소 활성화
                if (
                    isAmong(currentPos, obj.top, obj.bottom)
                ) {
                    enabled.set(refname, obj);
                    this.$refs[refname].classList.remove("disabled");
                    this.$refs[refname].classList.add("enabled");
                    disabled.delete(refname);
                }
            });

            // enabled 순회하면서 헤제할 요소를 체크
            enabled.forEach((obj, refname) => {
                const { top, bottom, topStyle, bottomStyle } = obj;
                // console.log(`${top}, ${bottom}, ${topStyle}, ${bottomStyle}`);
                // 범위 밖에 있다면
                if (!isAmong(currentPos, top, bottom)) {
                    // 위로 나갔다면 시작하는 스타일 적용
                    if (currentPos <= top) {
                        Object.keys(topStyle).forEach((styleName) => {
                            applyStyle(this.$refs[refname], styleName, topStyle[styleName]);
                        });
                    }
                    // 아래로 나갔다면 끝나는 스타일적용
                    else if (currentPos >= bottom) {
                        Object.keys(bottomStyle).forEach((styleName) => {
                            applyStyle(
                                this.$refs[refname],
                                styleName,
                                bottomStyle[styleName]
                            );
                            // this.$refs[refname].style[styleName] = bottomStyle[styleName];
                        });
                    }

                    // 리스트에서 삭제하고 disabled로 옮김.
                    disabled.set(refname, obj);
                    this.$refs[refname].classList.remove("enabled");
                    this.$refs[refname].classList.add("disabled");
                    enabled.delete(refname);
                }

                // enable 순회중, 범위 내부에 제대로 있다면 각 애니메이션 적용시키기.
                else {
                    this.applyAllAnimation(currentPos, refname);
                }
            });
        }
    }
});

function Clock (){
    var today = new Date();

    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);
    var hours = ('0' + today.getHours()).slice(-2); 
    var minutes = ('0' + today.getMinutes()).slice(-2);
    var seconds = ('0' + today.getSeconds()).slice(-2); 

    var dateString = year + '-' + month  + '-' + day;
    var timeString = hours + ':' + minutes  + ':' + seconds;
    document.getElementById("header-time").innerHTML = dateString + " | " + timeString;
}
Clock();
setInterval(Clock, 1000);
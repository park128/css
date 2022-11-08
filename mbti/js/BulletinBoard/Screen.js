var controller = new ScrollMagic.Controller();
var tl = new TimelineMax();
tl.staggerFrom(".box", 1.25, {
    scale: 0,
    cycle: {
    y: [-50, 50]
    },
ease: Elastic.easeOut,
stagger: {
    from: "center",
    amount: 0.25
}
});

var scene = new ScrollMagic.Scene({
    triggerElement: "#stage",
    triggerHook: 0
})

.addIndicators({
    colorTrigger: "white",
    colorStart: "white",
    colorEnd: "white",
    indent: 5
})
.setTween(tl)
.addTo(controller);
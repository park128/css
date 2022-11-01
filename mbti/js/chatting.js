document.addEventListener("mousemove", e => {
    gsap.to(".text", {
        x: e.clientX,
        y: e.clientY,
        stagger: { // wrap advanced options in an object
            each: -0.02,
            ease: "power2.inOut",
        }
    })
})
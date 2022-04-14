<template>
  <div class="message-container">
      <span class="profile-pic">
        <img :src="getImg(image.src)" :alt="image.alt" @dblclick="switchCat">
      </span>
      <span class="speech-bubble">
            {{ speechText }}
      </span>
  </div>
</template>

<script>
export default {
    name: "bot-speech-bubble",
    props: ["speechText"],
    data() {
        return {
            index: 1,
            image: {
                    src: "oliver-talking-2.gif",
                    alt: "Oliver the cat"
            },
            images: [
                {
                    src: "oliver-talking-2.gif",
                    alt: "Oliver the cat"
                },
                {
                    src: "b.gif",
                    alt: "Britt's cat"
                },
                {
                    src: "c.gif",
                    alt: "Chris's cat"
                },
                {
                    src: "../img/e.gif",
                    alt: "Emily's cat"
                }
            ]
        }
    },
    methods: {
        getImg(img) {
            return require(`../img/${img}`);
        },
        switchCat() {
            this.image = this.images[this.index];
            if (this.index < this.images.length - 1) {
              this.index = this.index + 1;
            } else {
                (this.index = 0)
            }  
        }
    }

}
</script>

<style>

.message-container {
    display: flex;
}

.profile-pic {
    max-width: 7%;
    min-height: 7%;
    margin-left: 5px; 
}

.speech-bubble {
    background-color: #B13D59;
    color: #F5F7F3;
    border-radius: 8px;
    flex-grow: 1;
    max-height: 10vh;
    margin-left: 20px;
    margin-right: 20px;
    padding: 10px;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    font-size: 3vh;
    text-align: center;
    min-height: 7%;
}


</style>
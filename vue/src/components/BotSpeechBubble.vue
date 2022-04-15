<template>
  <div class="message-container">
      <span id="profile-pic">
        <img :src="getImg($store.state.currentCat.src)" :alt="$store.state.currentCat.alt" @dblclick="switchCat">
      </span>
      <span id="bot-bubble" class="bubble">
            {{ speechText }}
      </span>
  </div>
</template>

<script>
export default {
    name: "bot-speech-bubble",
    props: ["speechText"],
    methods: {
        getImg(img) {
            return require(`../img/${img}`);
        },
        switchCat() {
            this.$store.commit('SWITCH_CAT');
        }
    }

}
</script>

<style style="scoped">

#profile-pic {
    height: 100%; 
}

#profile-pic > img {
  max-height: 100%;
  max-width: 100%;
  object-fit: contain;
}

#bot-bubble {
    background-color: #B13D59;
}


</style>
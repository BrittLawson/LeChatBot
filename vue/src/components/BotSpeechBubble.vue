<template>
  <div class="message-container">
      <span id="profile-pic">
        <img src="../img/oliver-talking-2.gif" alt="">
      </span>
      <span id="bot-bubble" class="bubble">
            {{ speechText }}
      </span>
  </div>
</template>

<script>
export default {
    name: "bot-speech-bubble",
    props: ["speechText"]

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
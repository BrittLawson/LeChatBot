<template>
  <div class="message-container">
      <span class="profile-pic">
        <img src="../img/oliver-talking-2.gif" alt="">
      </span>
      <span class="speech-bubble">
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
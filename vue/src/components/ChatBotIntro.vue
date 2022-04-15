<template>
  <div class = "bot-container">
    <bot-speech-bubble :speechText="getIntroText"/>
    <div class = "spacer"></div>
    <chat-bot-intro-input class="input-field"/>
  </div>
</template>

<script>
import ChatBotIntroInput from '@/components/ChatBotIntroInput.vue';
import BotSpeechBubble from './BotSpeechBubble.vue';
export default {
  components: {
    ChatBotIntroInput,
    BotSpeechBubble
  },
  computed: {
    getIntroText() {
      let catName = this.$store.state.currentCat.name;
      return "Hi! My name is " + catName + "!  What's your name?";
    }
  }
}
</script>

<style>


</style>
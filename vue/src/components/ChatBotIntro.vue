<template>
  <div class = "bot-container">
    <bot-speech-bubble :speechText="'Hi! My name is Oliver!  What\'s your name?'"/>
    <chat-bot-intro-input/>
  </div>
</template>

<script>
import ChatBotIntroInput from '@/components/ChatBotIntroInput.vue';
import BotSpeechBubble from './BotSpeechBubble.vue';
export default {
  components: {
    ChatBotIntroInput,
    BotSpeechBubble
  }
}
</script>

<style>


</style>
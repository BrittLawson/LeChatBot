<template>
  <div class="bot-container">
    <bot-speech-bubble :speechText="'Hey there, ' + this.$store.state.nameOfCurrentUser + '! Nice to meet meow! Ask me a question, or ask for help if you want to know what I can tell you about.'"/>
    <query-speech-bubble :speechText="$store.state.currentQueryString" v-if="!$store.state.currentQueryString==''"/>
    <bot-speech-bubble v-if="!this.$store.state.currentResponseObject.message==''" :speechText="this.$store.state.currentResponseObject.message" />
    <chat-bot-input class="input-field" />
  </div>
</template>

<script>
import ChatBotInput from '@/components/ChatBotInput.vue';
import BotSpeechBubble from './BotSpeechBubble.vue';
import QuerySpeechBubble from './QuerySpeechBubble.vue';

export default {
  components: {
    ChatBotInput,
    BotSpeechBubble,
    QuerySpeechBubble
  }
}
</script>

<style style="scoped">


</style>
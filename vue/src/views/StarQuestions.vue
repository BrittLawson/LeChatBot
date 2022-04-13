<template>
  <div>
    <chat-bot />
    <star-questions-info />    
  </div>
</template>

<script>
import StarQuestionsInfo from '@/components/StarQuestionsInfo.vue';
import ChatBot from '@/components/ChatBot.vue';
export default {
  components: {
    StarQuestionsInfo,
    ChatBot
  }
}
</script>

<style>

</style>
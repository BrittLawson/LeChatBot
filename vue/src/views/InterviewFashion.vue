<template>
  <div>
    <chat-bot />  
    <interview-fashion-info />
  </div>
</template>

<script>
import InterviewFashionInfo from '@/components/InterviewFashionInfo.vue';
import ChatBot from '@/components/ChatBot.vue';
export default {
  components: {
    InterviewFashionInfo,
    ChatBot
  }
}
</script>

<style>

</style>
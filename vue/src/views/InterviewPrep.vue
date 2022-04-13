<template>
  <div>
    <chat-bot />
    <interview-prep-info />
  </div>
</template>

<script>
import InterviewPrepInfo from '@/components/InterviewPrepInfo.vue';
import ChatBot from '@/components/ChatBot.vue';
export default {
  components: {
    InterviewPrepInfo,
    ChatBot
  }
}
</script>

<style>

</style>
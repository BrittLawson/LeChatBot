<template>
  <div>
    <chat-bot />
    <employer-follow-up-info />
  </div>
</template>

<script>
import EmployerFollowUpInfo from '@/components/EmployerFollowUpInfo.vue';
import ChatBot from '@/components/ChatBot.vue';
export default {
  components: {
    EmployerFollowUpInfo,
    ChatBot
  }
}
</script>

<style>

</style>
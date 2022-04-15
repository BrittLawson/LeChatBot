<template>
  <div class="message-container">
      <span id="query-bubble" class="bubble">
            {{ speechText }}
      </span>
  </div>
</template>

<script>
export default {
    name: "query-speech-bubble",
    props: ["speechText"]
}
</script>

<style style="scoped">

#query-bubble {
    background-color: #1F2B4A;
}
</style>
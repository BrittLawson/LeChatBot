<template>
  <button v-on:click="buttonClick()">
      {{ responseLink.message }}
  </button>
</template>

<script>
export default {
    name: "response-button",
    props: ["responseLink"],
    computed: {
        isExternal() {
            return this.responseLink.url != null;
        }
    },
    methods: {
        buttonClick() {
            if (this.isExternal) {
                window.open(this.responseLink.url, "_blank")
            } else {
                this.$router.push({name: this.responseLink.frontendRoutingParam});
            }
        }
    }
}
</script>

<style>

</style>
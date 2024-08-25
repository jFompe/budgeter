<template>
  <v-app>
    <v-main>
      <RouterView />
    </v-main>

    <AppFooter />
  </v-app>
</template>

<script setup>
import { RouterView } from 'vue-router';
</script>

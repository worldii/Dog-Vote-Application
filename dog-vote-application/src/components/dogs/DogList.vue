<template lang="">
    <b-container class="pt-3">
    
        <DogListItem v-for="dog in dogList" :key="dog.id" :dog="dog" />
    
    
    </b-container>
</template>

<script>
import DogListItem from "@/components/dogs/DogListItem.vue";
import http from "@/assets/js/http";
export default {

    data() {
        return {

            dogList: [],
        };
    },
    components: {
        DogListItem
    }
    , 
    created() {
        console.log('DogList created');

        http.get('/').then((response) => {

            console.log(response.data.content);
            this.dogList = response.data.content;
        });
    },
}
</script>

<style scope="">

</style>


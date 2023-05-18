<template lang="">
    <b-container class="m-1" id="dog-item-container" @click="dogDetail">
             <b-row>
            <b-col></b-col>
            <b-col cols="6"> 
                <img :src=dog.imageUrl id="dogImage">
            </b-col>
            <b-col></b-col>
        </b-row>
        <b-row class="pt-3">
            <b-col></b-col>
            <b-col cols="3" class="text-center">{{dog.name}}</b-col>
            <b-col cols="3" class="text-center">{{dog.voteCount}}</b-col>
            <b-col></b-col>
        </b-row>       
    </b-container>
</template>

<script>
export default {
    name: "DogListItem",
    props: {
        dog: {
            type: Object,
            required: true
        }
    },
    methods: {
        dogDetail() {
            this.$router.push({
                name: "dogsView",
                params: {
                    id: this.dog.id
                }
            });
        }
    },
}
</script>

<style scoped>
#dogImage {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 2rem;
}
#dog-item-container {
    font-family: 'IBM-Plex-Sans-KR-semibold';
    font-size:  2rem;
   
}
</style>
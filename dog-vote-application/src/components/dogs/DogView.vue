<template lang="">
    <b-container id="dogViewContainer">
    
        <b-row class="p-3">
            <b-col></b-col>
    
            <b-button @click="backMove">뒤로 가기</b-button>
            <b-col></b-col>
    
        </b-row>
        <b-row>
            <b-col></b-col>
    
            <b-col cols="6">
                <img :src=dog.imageUrl id="dogImage">
            </b-col>
            <b-col></b-col>
        </b-row>
        <b-row class="pt-3">
            <b-col></b-col>
            <b-col cols="6" class="text-center">{{dog.name}}</b-col>
            <b-col></b-col>
        </b-row>
        <b-row>
            <b-col></b-col>
            <b-col> {{dog.description}}
            </b-col>
            <b-col> {{dog.detail}}
            </b-col>
    
            <b-col></b-col>
        </b-row>
        <b-row>
            <b-col></b-col>
            <b-col cols="3"> {{dog.name}} 에게 표를 주시겠습니까?
            </b-col>
            <b-col></b-col>
        </b-row>
        <b-row>
            <b-col></b-col>
            <b-col cols="3" class="text-center">{{dog.voteCount}}</b-col>
    
            <b-col></b-col>
        </b-row>
        <b-row @click="voteDog">
            <b-col></b-col>
            <span v-if="isVote"  >
                 <b-icon-heart-fill id="dogVoteHeart"></b-icon-heart-fill>
             </span>
            <span v-else>                
                <b-icon-heart id="dogVoteHeart"></b-icon-heart>
            </span>
            <b-col></b-col>
        </b-row>
    </b-container>
</template>

<script>
import http from "@/assets/js/http";

export default {
    name: "DogView",
    data() {
        return {
            isVote: false,
            dog: {},
        }
    },
    methods: {
        backMove() {
            this.$router.go(-1);
        },
        voteDog() {
            if (this.isVote) { 
                // unvote 
                http.post('/unvote/' + this.$route.params.id ).then((response) => {
                    console.log(response.data);             
                    this.isVote = !this.isVote;
                     console.log(this.isVote)
                    // reload
                    http.get('/' + this.$route.params.id).then((response) => {
                        console.log(response.data);
                        this.dog = response.data;
                    });
                }).catch((error) => {
                    console.log(error);
                });

            }
            else { 
                // vote
                http.post('/vote/' + this.$route.params.id ).then((response) => {
                    console.log(response.data);
                    this.isVote = !this.isVote;
                    console.log(this.isVote);
                    // reload 
                    http.get('/' + this.$route.params.id).then((response) => {
                        console.log(response.data);
                        this.dog = response.data;
                    });
                }).catch((error) => {
                    console.log(error);
                });
            }


            
        }
    },
    created() {
        console.log(this.$route.params.id);
        http.get('/' + this.$route.params.id).then((response) => {
            console.log(response.data);
            this.dog = response.data;
        });
    },

}
</script>

<style scoped>
#dogViewContainer {
    font-family: 'IBM-Plex-Sans-KR-semibold';
}

#dogImage {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 2rem;
}
#dogVoteHeart{
    font-size: 3rem;
    color: #FF0000;
}
</style>
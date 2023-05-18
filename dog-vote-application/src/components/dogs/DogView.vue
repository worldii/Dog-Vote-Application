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
export default {
    name: "DogView",
    data() {
        return {
            isVote: false,
            dog: {
                
            id: 1,
                name: '불독',
                    description: '불독은 중형견으로 근육질이며 튼튼한 체격을 가지고 있습니다. 주목할만한 특징은 피부가 주름있고, 튀어나온 코를 가지고 있다는 것입니다.',
                        detail: '불독은 친근하고 온순한 품종입니다. 불굴의 상징으로 알려져 있으며 끈기와 결단력의 상징으로 인식되기도 합니다. 겉으로는 겁이 많아 보일 수도 있지만 실제로는 극도로 용감하고 충성스러운 성격을 가지고 있습니다.',
                            voteCount: 10,
                                imageUrl: 'https://loremflickr.com/320/240/dog',

        
               
            },
        }
    },
    methods: {
        backMove() {
            this.$router.go(-1);
        },
        voteDog() {
            this.isVote = !this.isVote;
            console.log(this.isVote)
            
        }

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
package org.springhispano.java7.showcase

import grails.converters.JSON

class TwitterExportController {
	def twitter
    def timeline = {
		render twitter.timelineOperations().getHomeTimeline() as JSON
	}
	def mentions = {
		render twitter.timelineOperations().getMentions() as JSON
	}
	def followers = {
		render twitter.friendOperations().getFollowers() as JSON
	}
	def friends = {
		render twitter.friendOperations().getFriends() as JSON
	}
	def updateStatus = {
		def message = (params.message ?: params.id) ?: 'A poco no rifa Grails?'
        render twitter.timelineOperations().updateStatus(message) as JSON
	}
	def search = {
		def query = (params.id ?: params.q) ?: 'Grails'
        def tweets = twitter.searchOperations().search(query).getTweets()
		render tweets as JSON
	}
}

package com.candied

object SpoofDb {
  /**
    * A base trait representing the minimum required values to create a spoofed database in which to store records.
    */
  trait Record {
    val recordId: String
  }
}

class SpoofDb[T <: SpoofDb.Record] {
  var records = Set.empty[T]

  /**
    * Retrieve the set of Records.
    *
    * @return
    */
  def getRecords: Set[T] =
    records

  /**
    * Retrieve a Record by its ID, if it exists.
    *
    * @param recordId The ID of the Record to retrieve
    * @return
    */
  def getRecord(recordId: String): Option[T] =
    records.find(_.recordId == recordId)

  /**
    * Add a Record to the set of Records.
    *
    * @param record The Record to add to the set
    */
  def createRecord(record: T): Unit =
    records += record

  /**
    * Delete a Record by its ID, if it exists.
    *
    * @param recordId The ID of the Record to delete
    */
  def deleteRecord(recordId: String): Unit =
    records.find(_.recordId == recordId).foreach(records -= _)
}

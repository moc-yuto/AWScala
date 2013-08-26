package awscala.dynamodb

import scala.collection.JavaConverters._
import com.amazonaws.services.{ dynamodbv2 => aws }

object Projection {
  def apply(p: aws.model.Projection): Projection = new Projection(
    nonKeyAttributes = p.getNonKeyAttributes.asScala,
    projectionType = aws.model.ProjectionType.fromValue(p.getProjectionType)
  )
}

case class Projection(projectionType: ProjectionType, nonKeyAttributes: Seq[String] = Nil) extends aws.model.Projection {
  setProjectionType(projectionType)
  setNonKeyAttributes(nonKeyAttributes.asJava)
}

